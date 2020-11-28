package scc.serverless;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.LinkedList;
import java.util.List;

import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Timer Trigger.
 */
public class BlobStoreFunction
{
	
    @FunctionName("blobtest")
	public void run(
			@BlobTrigger(name = "blob", dataType = "binary", path = "sccproject/{name}", connection = "BlobStoreConnection") byte[] content,
			@BindingName("name") String blobname, final ExecutionContext context) throws InvalidKeyException, URISyntaxException, StorageException {
			
    	List<CloudBlobContainer> list = new LinkedList<>(BlobClients.createBlobClients().getBlobContainers());
    	
    	for(CloudBlobContainer b: list)
    	{
    		CloudBlockBlob blob = null;
    		
    		try {
    			blob = b.getBlockBlobReference(blobname);
    			blob.uploadFromByteArray(content, 0, content.length);
    		}
    		catch(Exception i)
    		{
    			
    		}
    	}
	}

}
