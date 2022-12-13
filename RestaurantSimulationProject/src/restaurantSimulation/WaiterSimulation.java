package restaurantSimulation;

import java.util.ArrayList;
import java.util.List;

public class WaiterSimulation {
	
    private List<Waiter> waiters = new ArrayList<>();
    private List<Table> waitingTable = new ArrayList<>();
    private static WaiterSimulation instanceWaiter;
    private static int NUM_OF_WAİTER = 4;
   
    private WaiterSimulation(){}
    
    public static synchronized WaiterSimulation getInstanceWaiter(){
        if (instanceWaiter == null) {
        	instanceWaiter = new WaiterSimulation();
        }
        return instanceWaiter;
    }
    public synchronized Waiter takeOrder(Table table){
    	if(waitingTable.isEmpty()){       //waiting listesi boş mu?
            if(waiters.isEmpty()){     //garson boş mu?
                if(NUM_OF_WAİTER != 0){   //garson boş durumda ve obje oluşturma hakkımız var
                    return makeWaiter();
                }else{              //      garson boş durumda ve obje oluşturulamaz durumdayız.
             
                    waitingTable.add(table);
                    return null;
                }
            }else{                   //waiting listesi boş ve garson dolu ise 
                return getFromWaiter();
            }
    	}else{          // Waiting listesinde en az bir kişi varsa
            if(waitingTable.contains(table)){        // Obje isteği yapan masa listesinde ise
                if(waiters.isEmpty()){                  // garson boş mu?
                    if(NUM_OF_WAİTER != 0){  //garson boş ve obje oluşturma hakkımız var ise oluşturulur ve gönderilir.
                        return makeWaiter();
                    }
                }else{                                  // waiting listesinde ve garsonda obje var  
                    return getFromWaiter();
                }
            }else{      ///waiting'de masa yok ise waiting'e eklenir ve bekletilir
                waitingTable.add(table);
                return null;
            }
        }
		return null;
    	}
    public synchronized void releaseWaiter(Waiter waiter, Table table){
        waiters.add(waiter);
    }
    private Waiter makeWaiter(){ //garson nesnesi oluşturduk 
        Waiter waiter = null;
        waiter = new Waiter(NUM_OF_WAİTER);
        NUM_OF_WAİTER--;
        return waiter;
    }
    private Waiter getFromWaiter(){
        Waiter response = waiters.get(0);
        waiters.remove(0);
        return response;
    }
}

    
