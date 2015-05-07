package com.zeef.hackbattle.linksmanager;

import com.zeef.client.api.BlockApi;
import com.zeef.client.api.LinkApi;
import com.zeef.client.model.Link;
import com.zeef.client.model.LinkBlock;
import com.zeef.hackbattle.apiinvoker.Invoker;

public class LinkManager {

	private Invoker invoker;

	public LinkManager(Invoker invoker) {
		this.invoker = invoker;
	}

	public Link addLinkToBlock(Long blockId, String url, String title, String desc) {
		BlockApi blockApi = new BlockApi(invoker.getAPIInvoker());
		LinkBlock linkBlock = (LinkBlock) blockApi.addLink(blockId, url, title, desc, 1);
		Link link = null;
		for (Link linkInBlock : linkBlock.getLinks()) {
			if (linkInBlock.getUrl().equals(url)) {
				link = linkInBlock;
			}
		}
		return link;
	}

	public void deleteLink(Long linkId) {
		LinkApi linkApi = new LinkApi(invoker.getAPIInvoker());
		linkApi.delete(linkId);
	}
}
