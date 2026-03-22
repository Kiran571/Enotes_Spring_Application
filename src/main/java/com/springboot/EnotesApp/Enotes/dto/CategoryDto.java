package com.springboot.EnotesApp.Enotes.dto;



/*
 * Class is middleware between Category class and other controller.
 * 
 * 
 * 
 * */

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

	private Integer id;
	
	@NotBlank
	@Size(min = 3,max = 10,message = "Size must be 2 to 10")
	private String name;
	
	@NotBlank
	@Size(min = 3,max = 100,message = "Description must be 2 to 10")
	private String description;
	
	@NotNull
	private Boolean isActive;
	
	@Column(name="is_deleted")
	private Boolean isDeleted;
	
	private Integer createdBy;
	
	private Date createdOn;
	
	private Integer updatedBy;
	
	@Column(name="updated_on")
	private Date updatedDate;
	
}
