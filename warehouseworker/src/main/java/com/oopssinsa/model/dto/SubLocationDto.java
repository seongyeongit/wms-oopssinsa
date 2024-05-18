package com.oopssinsa.model.dto;

// 지시 때 받은 locationId로 현재용량 변경
// locationId를 통해 브랜드와 카테고리를 알 수 있다
// 용량은 부피가 필요함, 부피*수량을 입고시 더하고, 출고시 뺀다.
// 구역 용량 변경을 염두해둘것
public class SubLocationDto {
    private long id;
    private int currentCapacity;
    private int sumOfSection; // 구역별 현재용량

    public SubLocationDto(long id, int currentCapacity, int sumOfSection) {
        this.id = id;
        this.currentCapacity = currentCapacity;
        this.sumOfSection = sumOfSection;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getSumOfSection() {
        return sumOfSection;
    }

    public void setSumOfSection(int sumOfSection) {
        this.sumOfSection = sumOfSection;
    }
}
