package clockController;

import clockModel.ClockModel;

public class ClockControllerH extends ClockControllerDecorator {

	public ClockControllerH (AClockController controller)  {super(controller);}
	
	@Override
	public void setHour(int hour){
		System.out.println("ClockControllerH - setHour");
		int h = hour % ClockModel.MAX_HOUR;
		if (h < ClockModel.MIN_TIME){ 
			h = h + ClockModel.MAX_HOUR;
		}
		try {
			myController.getModel().setHour(h);
		} 
		catch (Exception e) {
			System.out.println(e);
		} 
	}
	
	 @Override
	 public void incHour(int hour){ 
		 System.out.println("ClockControllerH - incHour");
		 int hh = myController.getModel().getHour();
		 this.setHour(hh+hour); 
	 } 
}

