package diffwaystocreatebodyinrequests;

public class POJO_For_Post_Req 
{
	String name;
	String location;
	String mobile;
	String[] courses;


	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}


}
