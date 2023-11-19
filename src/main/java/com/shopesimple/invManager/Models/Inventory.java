package com.shopesimple.invManager.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Inventory extends BaseModel{
  @ManyToOne
  private User user;
  @ManyToOne
  private Product product;

}
