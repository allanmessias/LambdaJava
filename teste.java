import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Main.execute(5);
    }

    public static long execute(int number) throws InterruptedException, ExecutionException {
        CompletableFuture<Long> completableFutureResponse = CompletableFuture.supplyAsync(() -> factorial(number));

        completableFutureResponse.thenApplyAsync((result) -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("async -> in thread " + threadName + " reasult before apply is " + result + "\n");
            return result * 10;
        })
                .thenAccept((res) -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("async -> in thread " + threadName + " final result is: " + res);
                });
        return number;
    }

    public static long factorial(int number) {
        int fac = 1;
        for (int i = 1; i < number; i++) {
            fac = fac * number;
        }
        return fac;
    }
}
