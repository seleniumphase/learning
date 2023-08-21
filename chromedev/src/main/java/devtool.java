import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.fetch.Fetch;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.Response;

public class devtool {

	public static void main(String[] args) {
		
		
		
		
		System.getProperty("Webdriver.chrome.driver", "F:\\Hetal\\chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtools  = driver.getDevTools();
		devtools.createSession();
		
        Map<String, Object> deviceMetrics = new HashMap<String, Object>()
        {{
            put("width", 390);
            put("height", 844);
            put("mobile", true);
            put("deviceScaleFactor", 20);
        }};
        
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.addListener(Network.requestWillBeSent(), request->
		{
			System.out.println(request.getRequest().getUrl());
			//System.out.println(request.getRequest().getPostData());
		}
				);
		devtools.addListener(Network.responseReceived(), response->
		{
			//Response res = response.getResponse();
			System.out.println(response.getResponse().getStatus());
		}
				);
		
		//devtools.addListener(Fetch.enable(null, null), null);
		
		driver.get("https://www.flipkart.com/");
		System.out.println("new");
		
		
		
		
	}

}
