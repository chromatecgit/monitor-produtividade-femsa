package br.com.shelfpix.util;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public abstract class CalculadorCommons {
	
	//TODO: Procurar somente quando o mês mudar (colocar em um atributo estático)
	public int encontrarDiasUteis() {
		int counter = 0;
		LocalDate dataAtual = LocalDate.now();
		LocalDate primeiroDia = dataAtual.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate ultimo = dataAtual.with(TemporalAdjusters.lastDayOfMonth());

		for (int i = primeiroDia.getDayOfMonth(); i <= ultimo.getDayOfMonth(); i++) {
			LocalDate dataTemp = LocalDate.of(dataAtual.getYear(), dataAtual.getMonth(), i);
			if (!dataTemp.getDayOfWeek().equals(DayOfWeek.SATURDAY)
					&& !dataTemp.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
				counter++;
			}
		}

		return counter;
	}

	public double dividir(int qntdLojasVisitadas, Duration qntdHorasTrabalho) {
		if (qntdHorasTrabalho.getSeconds() != 0) {
			double conversao = converterSegundosEmHorasDecimal(qntdHorasTrabalho.getSeconds());
			double resultado = qntdLojasVisitadas / conversao;
			return resultado;
		}
		return 0.0d;
	}

	public double dividir(Duration qntdHorasTrabalho, double d) {
		if (qntdHorasTrabalho.getSeconds() != 0) {
			double conversao = converterSegundosEmHorasDecimal(qntdHorasTrabalho.getSeconds());
			double resultado = conversao / d;
			return resultado;
		}
		return 0.0d;
	}

	public double dividir(double numero, Duration qntdHorasTrabalho) {
		if (qntdHorasTrabalho.getSeconds() != 0) {
			double conversao = converterSegundosEmHorasDecimal(qntdHorasTrabalho.getSeconds());
			double resultado = numero / conversao;
			return resultado;
		}
		return 0.0d;
	}

	public double converterSegundosEmHorasDecimal(double numero) {
		return numero / 3600;
	}

	public double dividir(int n1, int n2) {
		if (n2 != 0) {
			return ((double) n1 / n2);
		} else {
			return 0;
		}
	}

	public double dividir(double n1, int n2) {
		if (n2 != 0) {
			return n1 / n2;
		} else {
			return 0;
		}
	}

	public double dividir(double n1, double n2) {
		if (n2 != 0) {
			return n1 / n2;
		} else {
			return 0;
		}
	}

	public double dividir(int n1, double n2) {
		if (n2 != 0) {
			return n1 / n2;
		} else {
			return 0;
		}
	}

	public double checarValorZero(double valor) {
		return valor < 0 ? 0 : valor;
	}
	
	//Procurar um modo de usar generics aqui
	//public abstract <T extends ProgressoDiario> T calcularAcumulado(List<Pesquisador> pesquisadores);
}
