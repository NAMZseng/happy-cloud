package models;

import java.sql.Date;

import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class user_share_file extends Model {
	
	public int user_id;
	public int file_id;
	public String file_name;
	public String file_type;
	public Date share_time;
	public Date share_count;
	
	@Override
	public String toString() {
	
		return file_name;
	}

}
