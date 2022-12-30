package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Task-Management")
public class TaskManagement {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int taskId;
		@Column(name="taskHolderName")
		private String taskHolderName;
		
		@Column(name="taskDate")
		private String taskDate;
		
		@Column(name="taskName")
		private String taskName;
		
		@Column(name="taskStatus")
		private String taskStatus;
		
		
		
		public int getTaskId() {
			return taskId;
		}
		public void setTaskId(int taskid) {
			this.taskId = taskid;
		}
		public String getTaskHolderName() {
			return taskHolderName;
		}
		public void setTaskHolderName(String taskHolderName) {
			this.taskHolderName = taskHolderName;
		}
		public String getTaskDate() {
			return taskDate;
		}
		public void setTaskDate(String taskDate) {
			this.taskDate = taskDate;
		}
		public String getTaskName() {
			return taskName;
		}
		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}
		public String getTaskStatus() {
			return taskStatus;
		}
		public void setTaskStatus(String taskStatus) {
			this.taskStatus = taskStatus;
		}
		
		
}
