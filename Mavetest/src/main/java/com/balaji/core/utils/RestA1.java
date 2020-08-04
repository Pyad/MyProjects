package com.balaji.core.utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestA1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url("https://cognizant.sc.omtrdc.net/b/ss/ctsprodlive/1/JS-2.13.1-LATI/s22766067501541?AQB=1&ndh=1&pf=1&t=13/5/2020 18:14:53 6 -330&sdid=6B2656E7C61ABD51-289D3749DBA4C585&mid=80515921477807029612112017070909779118&aamlh=12&ce=utf-8&pageName=Digital Solutions to Advance Your Business | Cognizant&g=https://www.cognizant.com/&cc=USD&c4=D=g&v4=D=g&c5=D=v5&v5=Top Nav Header | Careers&v15=Digital Solutions to Advance Your Business | Cognizant&c16=D=v16&v16=D=g&c18=D=v18&v18=Digital Solutions to Advance Your Business- Cognizant | Home Page&pe=lnk_o&pev1=https://www.cognizant.com/careers&pev2=Careers&c.&a.&activitymap.&page=Digital Solutions to Advance Your Business | Cognizant&link=Careers&region=bodyId&pageIDType=1&.activitymap&.a&.c&pid=Digital Solutions to Advance Your Business | Cognizant&pidt=1&oid=https://www.cognizant.com/careers&ot=A&s=1366x768&c=24&j=1.6&v=N&k=Y&bw=1034&bh=572&mcorgid=00FD3942552521970A4C98A4@AdobeOrg&AQE=1")
				  .method("GET", null)
				  .addHeader("Cookie", "s_vi_hx7Fxxx7Bydogbx7Dn=[CS]v4|2F7265748515CBFA-60000911C75F7407|5EE4CAE9[CE]")
				  .build();
				Response response = client.newCall(request).execute();
				System.out.println(response);

	}

}
