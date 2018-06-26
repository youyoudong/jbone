package cn.jbone.eb.portal.api.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class OperationPositionListByPageResponseDTO {
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<OperationPostionBaseInfoDTO> getRows() {
        return rows;
    }

    public void setRows(List<OperationPostionBaseInfoDTO> rows) {
        this.rows = rows;
    }

    private long total;
    private List<OperationPostionBaseInfoDTO> rows;
}
