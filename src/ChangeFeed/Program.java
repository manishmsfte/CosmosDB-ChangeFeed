package ChangeFeed;


import com.microsoft.azure.cosmosdb.changefeedprocessor.ChangeFeedProcessor;


public class Program {

	public static final String DATABASE_NAME = "ChangeFeedDB";
    public static final String COLLECTION_NAME = "coll1";
    public static final String LEASE_COLLECTION_NAME = "leases";
    public static final String HOSTNAME="https://fncosmosdb.documents.azure.com:443/";
    public static final String MASTERKEY="eF3daiXFZ86sD5h96hG9pdsSzmQgqIKKQKc2ZcpmiqkC2rpExJv5wvOwDtLe5dI9z6N78IMSCgDsg6MrQEcMoA==";

    public static void main (String[]args) {
        System.out.println("BEGIN Sample");

        try {

            System.out.println("-->Subscribed ChangeFeed");
          // AsyncDocumentClient leaseDocumentClient = ChangeFeedHelper.getCosmosDbClient( HOSTNAME,MASTERKEY);
            System.out.println("-->Subscribed ChangeFeed1");
            
              ChangeFeedProcessor changeFeedProcessor1 = ChangeFeedHelper.
            		getChangeFeedProcessor("fncosmosdb", DATABASE_NAME, COLLECTION_NAME, 
            				LEASE_COLLECTION_NAME , HOSTNAME,MASTERKEY);

            
            
            changeFeedProcessor1.start();
            
            Thread.sleep(150000);
            
              

            
            Thread.sleep(15000);

            changeFeedProcessor1.stop();

            
            //System.out.println("-->Released ChangeFeed");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("END Sample");
        System.exit(0);
    }

}
