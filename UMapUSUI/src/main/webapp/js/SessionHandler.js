var UMapUS = UMapUS || {};

UMapUS.SessionHandler = function()
{
        var self = this;
	
	    self.sess_pollInterval = 60000;
	    self.sess_expirationMinutes = 10;
	    self.sess_warningMinutes = 1;
	    self.sess_intervalID;
	    self.sess_lastActivity;

        self.initSession = function() {
            self.sess_lastActivity = new Date();
            self.sessSetInterval();
            $(document).bind('keypress.session', function (ed, e) {
                self.sessionActive(ed, e);
            });
            $(document).bind('mousemove', function(ed,e)
            {
            	self.sessionActive(ed, e);
            });
        };
        
        self.sessSetInterval = function () {
            sess_intervalID = setInterval('UMapUS.sessionHandler.sessInterval()', self.sess_pollInterval);
        };
        self.sessClearInterval = function() {
            clearInterval(self.sess_intervalID);
;
        };
        self.sessionActive = function(ed, e) {
        	self.sess_lastActivity = new Date();
        };
        self.sessLogOut = function() {
        	var url = "/UMapUSUI/logout";
        	var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
			$.ajax({				
				type : "POST",
				url : url,
				beforeSend: function (request)
	            {
	                request.setRequestHeader(header, token);
	            },
				contentType : "application/json",
				consumes : "application/json",
				success : function(data, textStatus, jqXHR) {
					//alert("Logged out successful");
					window.location.href = "/UMapUSUI";
				},
				error : function(data) {
					alert("Unable to Logout" + data);
				}
				
			});
        };
        self.sessInterval = function() {
            var now = new Date();
            //get milliseconds of differneces
            var diff = now - self.sess_lastActivity;
            //get minutes between differences
            var diffMins = (diff / 1000 / 60);
            if (diffMins >= self.sess_warningMinutes) {
                //warn before expiring
                //stop the timer
            	self.sessClearInterval();
                //prompt for attention
                var active = confirm('Your session will expire in ' + 
                (self.sess_expirationMinutes - self.sess_warningMinutes) +
                ' minutes (as of ' + now.toTimeString() + '), Press OK to remain logged in ' +'or Press Cancel to log off. \nIf you are logged off any changes will be lost.');
                if (active == true) {
                    now = new Date();
                    diff = now - self.sess_lastActivity;
                    diffMins = (diff / 1000 / 60);
                    if (diffMins > self.sess_expirationMinutes) {
                        self.sessLogOut();
                    }
                    else {
                        self.initSession();
                        self.sessSetInterval();
                        self.sess_lastActivity = new Date();
                    }
                }
                else {
                	self.sessLogOut();
                }
            }
        };
        
};

UMapUS.sessionHandler = new UMapUS.SessionHandler();