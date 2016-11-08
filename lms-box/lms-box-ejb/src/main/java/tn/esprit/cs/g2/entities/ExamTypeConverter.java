package tn.esprit.cs.g2.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ExamTypeConverter implements AttributeConverter<ExamType, String> {

	@Override
	public String convertToDatabaseColumn(ExamType attribute) {
		switch (attribute) {
		case TD:
			return "TD";
		case TP:
			return "TP";
		case DS:
			return "DS";
		case EXAM:
			return "EXAM";
		case PROJECT:
			return "PROJECT";
		default:
			throw new IllegalArgumentException("Unknown" + attribute);
		}
	}

	@Override
	public ExamType convertToEntityAttribute(String dbData) {
		switch (dbData) {
		case "TD":
			return ExamType.TD;
		case "TP":
			return ExamType.TP;
		case "DS":
			return ExamType.DS;
		case "EXAM":
			return ExamType.EXAM;
		case "PROJECT":
			return ExamType.PROJECT;
		default:
			throw new IllegalArgumentException("Unknown" + dbData);
		}
	}

}
