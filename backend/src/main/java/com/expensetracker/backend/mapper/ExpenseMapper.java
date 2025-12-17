package com.expensetracker.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.expensetracker.backend.dto.ExpenseDto;
import com.expensetracker.backend.entities.Expense;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExpenseMapper {

    ExpenseDto toDto(Expense expense);
    @Mapping(target = "user", ignore = true)
    Expense toEntity(ExpenseDto expenseDto);


    

}






    

