package models;

import java.sql.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class user_download_file extends Model {

	  public int user_id;
	  public int file_id;
	  public String file_name;
	  public String file_type;
	  public Date download_time;
	  public Date download_count;
	  
	  
	@Override
	public String toString() {
		return file_name;
	}

}
