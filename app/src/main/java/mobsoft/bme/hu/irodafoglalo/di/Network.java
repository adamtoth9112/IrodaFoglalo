package mobsoft.bme.hu.irodafoglalo.di;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by mobsoft on 2016. 04. 18..
 */

@Qualifier
@Retention(RUNTIME)
public @interface Network {
}
