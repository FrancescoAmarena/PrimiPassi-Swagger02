package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("")
    @ApiOperation(value = "Restituisce un messaggio di benvenuto per la matematica API")
    public String welcomeMathMsg() {
        return "Benvenuto nella sezione Matematica di Math API!";
    }

    @GetMapping("/division-info")
    @ApiOperation(value = "Restituisce le informazioni sulla divisione")
    public ArithmeticOperation divisionInfo() {
        String[] properties = {"operation: division", "symbol: /"};
        return new ArithmeticOperation("Divisione", 2, "La divisione tra due numeri", properties);
    }

    @GetMapping("/multiplication")
    @ApiOperation(value = "Restituisce il risultato della moltiplicazione tra due numeri")
    public int multiplication(
            @ApiParam(value = "Il primo operando", required = true) @RequestParam int a,
            @ApiParam(value = "Il secondo operando", required = true) @RequestParam int b) {
        return a * b;
    }

    @GetMapping("/square/{n}")
    @ApiOperation(value = "Restituisce il quadrato di un numero")
    public int square(
            @ApiParam(value = "Il numero di cui calcolare il quadrato", required = true) @PathVariable int n) {
        return n * n;
    }
}
