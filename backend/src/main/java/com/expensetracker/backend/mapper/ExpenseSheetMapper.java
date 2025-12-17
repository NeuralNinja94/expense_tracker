package com.expensetracker.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.expensetracker.backend.dto.ExpenseSheetDto;
import com.expensetracker.backend.entities.ExpenseSheet;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExpenseSheetMapper {
    
    @Mapping(target = "userId", source = "user.id")
    ExpenseSheetDto toDto(ExpenseSheet expenseSheet);
    
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "expenses", ignore = true)
    ExpenseSheet toEntity(ExpenseSheetDto expenseSheetDto);
}
