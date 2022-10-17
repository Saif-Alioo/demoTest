package com.example.demo.entity;

import java.sql.Date;
import java.sql.Time;

//import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table
public class Task {

	@Id
	private int taskid;
	@Column
	@NotBlank(message="Task name is mandatory")
	private String taskName;
	@Column
	@NotBlank(message="Meeting start time is mandatory")
	private String startTime;
	@Column
	@NotBlank(message="Metting end time is mandatory")
	private String endTime;
	@Column
	private String taskdec;
	@Column
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date Date;
	@ManyToOne
	@JoinColumn(name="proid")
	Profile profile;
	
	
}
