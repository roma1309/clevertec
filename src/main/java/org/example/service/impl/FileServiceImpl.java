package org.example.service.impl;

import org.example.model.Check;
import org.example.model.ProductInCheck;
import org.example.service.FileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public void outputInFile(Check check) {

        File file = new File("CheckFile.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (ProductInCheck productInCheck : check.getProduct()) {
                printWriter.println("количество продуктов - " + productInCheck.getCount() + " название товара - " + productInCheck.getName()
                        + " цена одного - " + productInCheck.getCost() +
                        " скидка - " + productInCheck.getStock() + " сумма с учетом скидки - " + productInCheck.getTotal());
            }
            printWriter.println("скидка по карте - " + check.getTotalStock() +
                    " Вся цена без скидки - " + check.getTotalCost() + " С учетом скидки - " + check.getCost());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
