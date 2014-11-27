package com.umapus.common.domain.entity;

public enum SignUpResponse {

	SUCCESS {

		@Override
		public String getStatus() {

			return "success";
		}
	},
	ALREADY_EXISTS {

		@Override
		public String getStatus() {

			return "user_already_exists_and_active";
		}
	},
	ALREADY_EXISTS_INACTIVE {

		@Override
		public String getStatus() {

			return "user_already_exists_and_inactive";
		}
	},
	FAILED {

		@Override
		public String getStatus() {

			return "failed";
		}
	};

	public abstract String getStatus();

}
