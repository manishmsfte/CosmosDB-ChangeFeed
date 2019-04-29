package ChangeFeed;
/*
	 * The MIT License (MIT)
	 * Copyright (c) 2018 Microsoft Corporation
	 *
	 * Permission is hereby granted, free of charge, to any person obtaining a copy
	 * of this software and associated documentation files (the "Software"), to deal
	 * in the Software without restriction, including without limitation the rights
	 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	 * copies of the Software, and to permit persons to whom the Software is
	 * furnished to do so, subject to the following conditions:
	 *
	 * The above copyright notice and this permission notice shall be included in all
	 * copies or substantial portions of the Software.
	 *
	 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	 * SOFTWARE.
	 */

	import com.microsoft.azure.cosmosdb.ConnectionPolicy;
	import com.microsoft.azure.cosmosdb.ConsistencyLevel;
	import com.microsoft.azure.cosmosdb.changefeedprocessor.ChangeFeedProcessor;
	import com.microsoft.azure.cosmosdb.changefeedprocessor.DocumentCollectionInfo;
	import com.microsoft.azure.cosmosdb.rx.AsyncDocumentClient;


	/**
	 * Sample for ChangeFeed
	 *
	 */

public class ChangeFeedHelper {

	    
	    public static ChangeFeedProcessor getChangeFeedProcessor(String hostName, String databaseName, String collectionName, String collectionLeaseName, String HostName, String MasterKey) {
	        return ChangeFeedProcessor.Builder()
	            .withHostName(hostName)
	            .withFeedCollection(
	                new DocumentCollectionInfo()
	                    .withDatabaseName(databaseName)
	                    .withCollectionName(collectionName)
	                    .withUri(HostName)
	                    .withMasterKey(MasterKey))
	            .withLeaseCollection(
	                new DocumentCollectionInfo()
	                    .withDatabaseName(databaseName)
	                    .withCollectionName(collectionLeaseName)
	                    .withUri(HostName)
	                    .withMasterKey(MasterKey))
	            .withChangeFeedObserver(ChangeFeedObserverSample.class)
	            .build();
	    }

	    public static AsyncDocumentClient getCosmosDbClient(String hostName, String masterKey) {
	        try {
	            return new AsyncDocumentClient.Builder()
	                .withServiceEndpoint(hostName)
	                .withMasterKeyOrResourceToken(masterKey)
	                .withConnectionPolicy(ConnectionPolicy.GetDefault())
	                .withConsistencyLevel(ConsistencyLevel.Eventual)
	                .build();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
}


