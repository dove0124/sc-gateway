package cn.springcloud.book.util.result;

import cn.springcloud.book.util.page.Page;
import cn.springcloud.book.util.page.PageResult;

public class DataPageWrapper extends Metadata {

    /**
     * 版本序列化ID
     */
    private static final long serialVersionUID = -3416458067471205703L;

    public DataPageWrapper() {
        super(ReturnCode.OK);
    }

    public DataPageWrapper(PageResult<?> result) {
        super(ReturnCode.OK);
        this.data = result.getResult();
        Page page = result.getPage();
        this.pageSize = page.getPageNumber();
        this.pageNum = page.getCurrentPage();
        this.total = page.getTotalNumber();
    }

    public DataPageWrapper(ReturnCode code, Object t, Page page) {
        super(code);
        this.data = t;
        if (page == null) {
            // FixMe: Throw exception
        }
        this.pageSize = page.getPageNumber();
        this.pageNum = page.getCurrentPage();
        this.total = page.getTotalNumber();
    }

    // 数据模型
    private Object data;

    private int pageSize;
    private int pageNum;
    private int total;

    public Object getData() {
        return data;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getTotal() {
        return total;
    }
}
