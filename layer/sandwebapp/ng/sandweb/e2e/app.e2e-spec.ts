import { SandwebPage } from './app.po';

describe('sandweb App', () => {
  let page: SandwebPage;

  beforeEach(() => {
    page = new SandwebPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
