package by.epam.threadtask.service.exception;

import javax.xml.stream.XMLStreamException;

public class XMLParsingException extends Exception{
    public XMLParsingException(){};

    public XMLParsingException(String message) {
        super(message);
    }
}
