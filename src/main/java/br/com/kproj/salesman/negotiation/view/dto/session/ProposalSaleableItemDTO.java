package br.com.kproj.salesman.negotiation.view.dto.session;


import br.com.kproj.salesman.infrastructure.helpers.NumberHelper;
import br.com.kproj.salesman.negotiation.view.dto.UpdateQuantityPriceItemsDTO;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import static br.com.kproj.salesman.infrastructure.helpers.NumberHelper.isNegativeNumber;

public class ProposalSaleableItemDTO implements Serializable {

    private Long saleableId;
    private Integer quantity = 1;
    private BigDecimal price = BigDecimal.ZERO;

    private Set<ProposalPackageItemsDTO> packageItems = Sets.newHashSet();

    public ProposalSaleableItemDTO(Long saleableId) {
        this.saleableId = saleableId;
    }
    public ProposalSaleableItemDTO() {}

    public Set<ProposalPackageItemsDTO> getPackageItems() {
        return packageItems;
    }

    public void setPackageItems(Set<ProposalPackageItemsDTO> packageItems) {
        this.packageItems = packageItems;
    }

    public Long getSaleableId() {
        return saleableId;
    }

    public void setSaleableId(Long saleableId) {
        this.saleableId = saleableId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void addPackageItemDTO(Long saleableId, Integer quantity, BigDecimal price) {
        ProposalPackageItemsDTO item = new ProposalPackageItemsDTO();
        item.setPrice(price);
        item.setQuantity(quantity);
        item.setSaleableId(saleableId);

        packageItems.add(item);
    }

    public void updateItem(ProposalPackageItemsDTO item) {
        if (packageItems.contains(item)) {
            Optional<ProposalPackageItemsDTO> itemSelected = packageItems.stream().filter(itemFiltered
                        -> itemFiltered.equals(item)).findFirst();

            itemSelected.get().setPrice(item.getPrice());
            itemSelected.get().setQuantity(item.getQuantity());
            itemSelected.get().setSelected(item.getSelected());
        }
    }

    public void updateRootItem(UpdateQuantityPriceItemsDTO item) {

        this.price = !isNegativeNumber(item.getPrice()) ? item.getPrice(): this.price;
        this.quantity = item.getQuantity() >= 0 ? item.getQuantity() : this.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProposalSaleableItemDTO that = (ProposalSaleableItemDTO) o;

        return saleableId != null ? saleableId.equals(that.saleableId) : that.saleableId == null;

    }

    @Override
    public int hashCode() {
        return saleableId != null ? saleableId.hashCode() : 0;
    }
}
