package Step3Sorting;

public class RunTimeMeasurement {
		long time;
		public void startTimer() {
			time = System.currentTimeMillis();
		}
		public double stopTimer() {
			return ((System.currentTimeMillis() - time )/1000.0);
		}
}
