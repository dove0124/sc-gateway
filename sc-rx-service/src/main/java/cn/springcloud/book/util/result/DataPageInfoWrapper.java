package cn.springcloud.book.util.result;

import com.github.pagehelper.PageInfo;

/**
 * @author chujingnian
 */
public class DataPageInfoWrapper extends Metadata {

    private static final long serialVersionUID = -3416458067471205704L;

    public DataPageInfoWrapper() {
        super(ReturnCode.OK);
    }

    public DataPageInfoWrapper(PageInfo<?> result) {
        super(ReturnCode.OK);
        this.data = result.getList();
        this.pageSize = result.getPageSize();
        this.pageNum = result.getPageNum();
        this.total = result.getTotal();
    }

    // 数据模型
    private Object data;

    private int pageSize;
    private int pageNum;
    private long total;

    public Object getData() {
        return data;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public long getTotal() {
        return total;
    }
}
