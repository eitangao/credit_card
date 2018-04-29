package com.xmx.credit_card.dto;

import java.util.List;

public class PointDTO {

    private Integer totalPoint;

    private List<PointDetail> pointDetails;

    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }

    public List<PointDetail> getPointDetails() {
        return pointDetails;
    }

    public void setPointDetails(List<PointDetail> pointDetails) {
        this.pointDetails = pointDetails;
    }
}
