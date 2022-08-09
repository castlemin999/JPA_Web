package com.jpabook.jpashop.domainRe;

import com.jpabook.jpashop.domainRe.item.ItemRe;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class CategoryRe {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ItemRe> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private CategoryRe parent;

    @OneToMany(mappedBy = "parent")
    private List<CategoryRe> child = new ArrayList<>();

    public void addChildCategory(CategoryRe child) {
        this.child.add(child);
        child.setParent(this);
    }
}
