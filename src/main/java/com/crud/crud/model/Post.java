package com.crud.crud.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.crud.crud.dto.PostDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;;

@Data
@Entity 
@NoArgsConstructor

public class Post {

  public  Post( PostDTO data){
    this.description=data.description();
    this.imageURL=data.imageURL();
    this.likes=data.likes();
   
  }

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column( length = 250 , nullable = false)
private String description;

@Column( length = 5000 , nullable = false)
private String imageURL;

@Column( length = 5000 , nullable = false)
private int likes;
    
}
