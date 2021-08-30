package pe.gob.mpfn.support.cloud.codegen;

import io.swagger.codegen.v3.CodegenConstants;
import io.swagger.codegen.v3.CodegenParameter;
import io.swagger.codegen.v3.generators.java.SpringCodegen;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MpfnSpringGenerator extends SpringCodegen {

	private static final String LANGUAGE_NAME = "mpfn-spring";
	private static final Logger log = LoggerFactory.getLogger(MpfnSpringGenerator.class);

	@Override
	public String getName() {
		return LANGUAGE_NAME;
	}

	@Override
	protected String getTemplateDir() {
		return LANGUAGE_NAME;
	}

	@Override
	public CodegenParameter fromParameter(Parameter parameter, Set<String> imports) {
		final CodegenParameter codegenParameter = super.fromParameter(parameter, imports);
		if (parameter.getSchema() != null && isObjectSchema(parameter.getSchema())) {
			log.trace("{} is object", codegenParameter.getBaseName());
			codegenParameter.getVendorExtensions().putIfAbsent(CodegenConstants.IS_OBJECT_EXT_NAME, Boolean.TRUE);
		}
		return codegenParameter;
	}

}