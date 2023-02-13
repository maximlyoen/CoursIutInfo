package clockController;

import clockModel.ClockModel;

public class ClockControllerS extends ClockControllerDecorator {

	public ClockControllerS (AClockController controller)  	{super(controller);}
	
	@Override
	public void setSecond(int second){
		System.out.println("ClockControllerS - setSeconde");
		int ss = second % ClockModel.MAX_MINSEC;
		int mm = second / ClockModel.MAX_MINSEC;
		if ( ss < 0) { 
			ss = ss + ClockModel.MAX_MINSEC; mm = mm -1;
		}
		try {
			myController.getModel().setSecond(ss);
		} 
		catch (Exception e) {
			System.out.println(e);
		} 
		if ( mm != 0) {
			myController.incMinute(mm);
		}
	}
	
	 @Override
	 public void incSecond(int second){ 
		 System.out.println("ClockControllerS - incSeconde");
		 int ss = myController.getModel().getSecond();
		 this.setSecond(ss+second); 
	 }
}
