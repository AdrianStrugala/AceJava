package model;

public final class Communication {

	
	    private static class Holder {
	        static final Communication INSTANCE = new Communication();
	    }

	    public static Communication getInstance() {
	        return Holder.INSTANCE;
	    }
	    
	    //username
	    private static String name = null;
	    
		//message boxes
	    private static String ace = null;
	    private static String you = null;
	    
	    private static Boolean appear = false;
	    private static Boolean yappear = false;
	    
	    public  Boolean getYappear() {
			return Communication.yappear;
		}
		public void setYappear(Boolean yappear) {
			Communication.yappear = yappear;
		}
		public String getName() {
			return Communication.name;
		}
		public void setName(String name) {
			Communication.name = name;
		}
		public String getAce() {
			return Communication.ace;
		}
		public void setAce(String ace) {
			Communication.ace = ace;
		}
		public String getYou() {
			return Communication.you;
		}
		public void setYou(String you) {
			Communication.you = you;
		}

		public Boolean getAppear() {
			return Communication.appear;
		}
		public void setAppear(Boolean appear) {
			Communication.appear = appear;
		}
	
}
