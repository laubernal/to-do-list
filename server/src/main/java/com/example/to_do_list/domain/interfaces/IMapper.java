package com.example.to_do_list.domain.interfaces;

public interface IMapper<D, M> {
    public M toModel(D entity);

    public D toDomain(M model);
}
