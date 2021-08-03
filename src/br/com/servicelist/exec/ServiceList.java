package br.com.servicelist.exec;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.servicelist.controller.TransactionListController;
import br.com.servicelist.dto.Transaction;
import br.com.servicelist.dto.ValidatorMessage;
import br.com.servicelist.exception.IdValidationException;
import br.com.servicelist.exception.MonthValidationException;
import br.com.servicelist.exception.YearValidationException;
import br.com.servicelist.validator.IdValidator;
import br.com.servicelist.validator.MonthValidator;
import br.com.servicelist.validator.YearValidator;

@Path("/{id}/transacoes/{year}/{month}")
public class ServiceList extends javax.ws.rs.core.Application{
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response generateServiceList(@PathParam("id") String id, @PathParam("year") 
			String year, @PathParam("month") String month) {
		
		try {
			MonthValidator monthValidator = new MonthValidator();
			monthValidator.validateMonth(month);
			
			YearValidator yearValidator = new YearValidator();
			yearValidator.validateYear(year);
			
			IdValidator idValidator = new IdValidator();
			idValidator.validateId(id);
			
			TransactionListController controller = new TransactionListController();
			Transaction [] transactionList = controller.getTransactionList(
					Integer.parseInt(id), Integer.parseInt(month), Integer.parseInt(year));
			GenericEntity<Transaction[]> entity = new GenericEntity<Transaction[]>(transactionList) {};
			
			return Response.ok(entity,MediaType.APPLICATION_JSON).build();
		
		} catch (MonthValidationException | IdValidationException | YearValidationException e) {
			
			ValidatorMessage validatorMessage = new ValidatorMessage(e.getLocalizedMessage());
			
			return Response.status(Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON)
            		.entity(new GenericEntity<ValidatorMessage>(validatorMessage){}).build();
		
		} catch (Exception e) {
			
			ValidatorMessage validatorMessage = new ValidatorMessage(e.getLocalizedMessage());
			
			return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.TEXT_PLAIN)
					.entity(new GenericEntity<ValidatorMessage>(validatorMessage){}).build();
		}
		
		
		
	}
	

}
