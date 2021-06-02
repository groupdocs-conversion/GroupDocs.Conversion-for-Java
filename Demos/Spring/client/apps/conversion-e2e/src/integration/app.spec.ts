import { getGreeting } from '../support/app.po';

describe('conversion', () => {
  beforeEach(() => cy.visit('/'));

  it('should display welcome message', () => {
    getGreeting().contains('Welcome to conversion!');
  });
});
