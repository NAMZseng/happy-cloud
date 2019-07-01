package models;

import java.sql.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class user_info extends Model {

	public int user_id;
	public String name;
	public String phone;
	public String password;
	public Date create_time;
	
	public String toString() {
		return name;
	}
}
