package com.dewdrops.entity;

	import java.time.LocalDateTime;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;

	@Entity
	public class Registration {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer registrationId;

		// private Long id;
		private Integer eventId;
		private Integer userId;


		private LocalDateTime registrationDate = LocalDateTime.now();
		private String status ;

		public Registration() {
		}

		public Integer getRegistrationId() {
			return registrationId;
		}

		public void setRegistrationId(Integer registrationId) {
			this.registrationId = registrationId;
		}

		public Integer getEventId() {
			return eventId;
		}

		public void setEventId(Integer eventId) {
			this.eventId = eventId;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public LocalDateTime getRegistrationDate() {
			return registrationDate;
		}

		public void setRegistrationDate(LocalDateTime registrationDate) {
			this.registrationDate = registrationDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
}
