package com.cqu.entity;

import java.util.List;

/*
 * @author CHT
 * @date 创建时间：2017年7月13日 下午5:31:11
 * @version 1.0
 */
public class Page {

	private List<Base_inf> base_infs;
	private List<Business_inf> business_infs;
	private List<Commodity_inf> commodity_infs;
	private List<Deposit_record> deposit_records;
	private List<User_inf> user_infs;
	private List<Spend_record> spend_records;
	private List<User_score> user_scores;
	private List<ScoreCondition> scoreConditions;
    public List<ScoreCondition> getScoreConditions() {
		return scoreConditions;
	}

	public void setScoreConditions(List<ScoreCondition> scoreConditions) {
		this.scoreConditions = scoreConditions;
	}

	// 查询记录总数
    private int totalRecords;

    // 每页多少条记录
    private int pageSize;

    // 第几页
    private int pageNo;
    
    /**
     * @return 总页数
     * */
    public int getTotalPages(){
        return (totalRecords+pageSize-1)/pageSize;
    }

    /**
     * 计算当前页开始记录
     * @param pageSize 每页记录数
     * @param currentPage 当前第几页
     * @return 当前页开始记录号
     */
    public int countOffset(int currentPage,int pageSize){
        int offset = pageSize*(currentPage-1);
        return offset;
    }

    /**
     * @return 首页
     * */
    public int getTopPageNo(){
        return 1;
    }

    /**
     * @return 上一页
     * */
    public int getPreviousPageNo(){
        if(pageNo<=1){
            return 1;
        }
        return pageNo-1;
    }

    /**
     * @return 下一页
     * */
    public int getNextPageNo(){
        if(pageNo>=getBottomPageNo()){
            return getBottomPageNo();
        }
        return pageNo+1;
    }

    /**
     * @return 尾页
     * */
    public int getBottomPageNo(){
        return getTotalPages();
    }


//    public List<Base_inf> getList() {
//        return base_infs;
//    }
//
//    public void setList(List<Base_inf> list) {
//        this.base_infs = list;
//    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

	public List<Base_inf> getBase_infs() {
		return base_infs;
	}

	public void setBase_infs(List<Base_inf> base_infs) {
		this.base_infs = base_infs;
	}

	public List<Business_inf> getBusiness_infs() {
		return business_infs;
	}

	public void setBusiness_infs(List<Business_inf> business_infs) {
		this.business_infs = business_infs;
	}

	public List<Commodity_inf> getCommodity_infs() {
		return commodity_infs;
	}

	public void setCommodity_infs(List<Commodity_inf> commodity_infs) {
		this.commodity_infs = commodity_infs;
	}

	public List<Deposit_record> getDeposit_records() {
		return deposit_records;
	}

	public void setDeposit_records(List<Deposit_record> deposit_records) {
		this.deposit_records = deposit_records;
	}

	public List<User_inf> getUser_infs() {
		return user_infs;
	}

	public void setUser_infs(List<User_inf> user_infs) {
		this.user_infs = user_infs;
	}

	public List<Spend_record> getSpend_records() {
		return spend_records;
	}

	public void setSpend_records(List<Spend_record> spend_records) {
		this.spend_records = spend_records;
	}

	public List<User_score> getUser_scores() {
		return user_scores;
	}

	public void setUser_scores(List<User_score> user_scores) {
		this.user_scores = user_scores;
	}
    
    
}
