package scc.serverless;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.LinkedList;
import java.util.List;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

public class BlobClients {
	
	public List<CloudBlobContainer> containerList;
	static BlobClients blobClients;
	
	public 	BlobClients() throws InvalidKeyException, URISyntaxException, StorageException {
		
		containerList = new LinkedList<>();
		
		CloudBlobClient africaClient = CloudStorageAccount.parse("DefaultEndpointsProtocol=https;AccountName=clientum;AccountKey=Hp599Ic3iYYyxH36hpQvMBC/FvNd3fdbLNY4Ccqjdmn/TH8EXFcoV42cbYRNHTwbs9S3RIrYIZjgQToP0ElyJA==;EndpointSuffix=core.windows.net").createCloudBlobClient();
		
		CloudBlobContainer africaContainer = africaClient.getContainerReference("containerafrica");
		containerList.add(africaContainer);
		
		CloudBlobClient canadaClient = CloudStorageAccount.parse("DefaultEndpointsProtocol=https;AccountName=clientdois;AccountKey=9pHpGW/BREMuraM4tQhhRtnj4p+RC+Z8lkVE9XG4PfulY+7OklJv6qTX2DGEt7t2ZoTSZmmllrpdrng84PHC7w==;EndpointSuffix=core.windows.net").createCloudBlobClient();
		
		CloudBlobContainer canadaContainer = canadaClient.getContainerReference("containercanada");
		containerList.add(canadaContainer);	
	}
	
	public static BlobClients createBlobClients() throws InvalidKeyException, URISyntaxException, StorageException
	{
		if(blobClients == null)
			blobClients = new BlobClients();
		return blobClients;
	}
	
	public List<CloudBlobContainer> getBlobContainers()
	{
		return containerList;
	}
	
	

}
