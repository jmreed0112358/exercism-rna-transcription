package rnatranscription;

import java.security.InvalidParameterException;

import exceptions.NotImplementedException;

public class RnaTranscription
{
	private static Character getTranslation(Character input) {
		switch ( input ) {
			case 'G':
				return 'C';
			case 'C':
				return 'G';
			case 'T':
				return 'A';
			case 'A':
				return 'U';
			default:
				throw new InvalidParameterException();
		}
	}
	
	public static String ofDna(String input) {
		if ( input == null) {
			throw new NullPointerException();
		}
		
		input = sanitize(input);
		
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < input.length( ) ; i++ ) {
			sb.append( getTranslation( input.charAt( i ) ) );
		}
		
		return sb.toString( );
	}
	
	private static String sanitize(String input) {
		StringBuilder sb = new StringBuilder();
		
		input = input.toUpperCase( );
		for ( int i = 0 ; i < input.length( ) ; i++ ) {
			if ( input.charAt( i ) == 'G' || input.charAt( i ) == 'C' || input.charAt( i ) == 'T' || input.charAt( i ) == 'A' ) {
				sb.append( input.charAt( i ) );
			}
		}
		
		return sb.toString( );
	}
}
