package cn.jbone.eb.manager.core.service.vo.operation;

import java.util.List;

import lombok.Data;

@Data
public class OperationPositionListVo {
    private long total;
    private List<OperationBaseInfoVo> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<OperationBaseInfoVo> getRows() {
        return rows;
    }

    public void setRows(List<OperationBaseInfoVo> rows) {
        this.rows = rows;
    }
}
