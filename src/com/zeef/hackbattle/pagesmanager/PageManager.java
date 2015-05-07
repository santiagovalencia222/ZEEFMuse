package com.zeef.hackbattle.pagesmanager;

import java.util.List;

import com.zeef.client.api.PageApi;
import com.zeef.client.api.PagesApi;
import com.zeef.client.model.Page;
import com.zeef.client.model.Page.PageTypeEnum;
import com.zeef.client.model.PageOverview;
import com.zeef.hackbattle.apiinvoker.Invoker;

public class PageManager {

	private Invoker invoker;

	public PageManager(Invoker invoker) {
		this.invoker = invoker;
	}

	public Page createPage(String title, String lang, PageTypeEnum pageType) {
		PageApi pageApi = new PageApi(invoker.getAPIInvoker());
		Page page = pageApi.create(title, lang, pageType);
		return page;
	}

	public Page getPageById(Long pageId) {
		PageApi pageApi = new PageApi(invoker.getAPIInvoker());
		return pageApi.getPageByID(pageId);
	}

	public List<PageOverview> getAllPagges() {
		PagesApi pagesApi = new PagesApi(invoker.getAPIInvoker());
		return pagesApi.getMyPages().getPageOverviews();
	}

	public void setMarkdownDesc(Long pageId, String markDownDesc) {
		PageApi pageApi = new PageApi(invoker.getAPIInvoker());
		pageApi.updatePage(pageId, null, markDownDesc);
	}
}
