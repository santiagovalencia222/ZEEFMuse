package com.zeef.hackbattle.apiinvoker;

import com.zeef.client.ApiInvoker;

public class Invoker {

	private ApiInvoker apiInvoker;

	public Invoker() {
		apiInvoker = new ApiInvoker();
		apiInvoker.addHeader("Authorization", "OmniLogin auth=f6a70bee-c572-4623-851e-a2c2efd385c1");
	}

	public ApiInvoker getAPIInvoker() {
		return apiInvoker;
	}
}