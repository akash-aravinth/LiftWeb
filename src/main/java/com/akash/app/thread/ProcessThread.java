package com.akash.app.thread;

import com.akash.app.catchdb.CatchDB;
import com.akash.app.dao.RequestDao;
import com.akash.app.model.Request;

import java.util.Deque;
import java.util.concurrent.*;

public class ProcessThread implements Runnable{
    private RequestDao requestDao = RequestDao.getRequestDao();
    private CatchDB catchDB = CatchDB.getCatchDB();
    @Override
    public void run() {
        BlockingQueue<Runnable> requests = new LinkedBlockingQueue<>(10);
        ExecutorService service = new ThreadPoolExecutor(4,5,Long.MAX_VALUE, TimeUnit.SECONDS,requests);
        while (true){
            Deque<Request> requestQueue = requestDao.getRequests();
            if (!requestQueue.isEmpty()){
                int size = requestQueue.size();
                for (int i = 0;i<size;i++){
                    Request request = requestQueue.poll();
                    catchDB.getCatchRequests().add(request);
                    service.execute((Runnable) request);
                }
            }else{
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
