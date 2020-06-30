using LifeHack.Api.Controllers;
using LifeHack.Domain.Models;
using Microsoft.Extensions.Configuration;
using Moq;
using NUnit.Framework;
using System.Net.Http;

namespace Tests
{
    public class PersonControllerTests
    {
        [Test]
        public void PersonPostFails()
        {
            var mockFactory = new Mock<IHttpClientFactory>();
            var mockConfig = new Mock<IConfiguration>();
            var mockSection = new Mock<IConfigurationSection>();
            
            mockConfig.Setup(cfg => cfg.GetSection("LifeHackData")).Returns(mockSection.Object);
            mockSection.Setup(cfg => cfg.GetSection("Endpoint")).Returns(mockSection.Object);

            var req = new Person() {Name = "Jane Doe"};
            var res = new Person() { Name = "Jane Doe" };

            var mockController = new Mock<PersonController>(mockFactory.Object, mockConfig.Object);
            mockController.Setup(ctr => ctr.Post(new Person())).ReturnsAsync(res);

            var controller = mockController.Object;
            var result = controller.Post(new Person() { Name = "Jane Doe"}).Result;
            Assert.IsTrue(result == null);
        }

        [Test]
        public void PersonPostSuccess()
        {
            var mockFactory = new Mock<IHttpClientFactory>();
            var mockConfig = new Mock<IConfiguration>();
            var mockSection = new Mock<IConfigurationSection>();

            mockConfig.Setup(cfg => cfg.GetSection("LifeHackData")).Returns(mockSection.Object);
            mockSection.Setup(cfg => cfg.GetSection("Endpoint")).Returns(mockSection.Object);

            var req = new Person() { Name = "Jane Doe" };
            var res = new Person() { Name = "Jane Doe" };

            var mockController = new Mock<PersonController>(mockFactory.Object, mockConfig.Object);
            mockController.Setup(ctr => ctr.Post(req)).ReturnsAsync(res);

            var controller = mockController.Object;
            var result = controller.Post(req).Result;
            Assert.IsTrue(result.Name.Equals(res.Name));
        }
    }
}