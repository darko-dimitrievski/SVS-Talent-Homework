public class RobotWorker implements Work {

    @Override
    public void work() {
        System.out.println("RobotWorker.work");
    }

    @Override
    public void stopWorking() {
        System.out.println("RobotWorker.stopWorking");
    }
}
