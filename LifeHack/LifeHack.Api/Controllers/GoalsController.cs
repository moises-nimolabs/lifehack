using System;
using LifeHack.Domain.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using System.Net.Http;
using System.Threading.Tasks;

namespace LifeHack.Api.Controllers
{
    /// <summary>
    /// Fetches goals from the main Data Api
    /// </summary>
    [Route("api/[controller]")]
    [ApiController]
    public class GoalsController : ControllerBase
    {
        private readonly IHttpClientFactory _clientFactory;
        private readonly string _lifeHackDataEndpoint;

        public GoalsController(IHttpClientFactory clientFactory, IConfiguration configuration)
        {
            _clientFactory = clientFactory;
            _lifeHackDataEndpoint = configuration.GetSection("LifeHackData").GetSection("Endpoint").Value;
        }

        /// <summary>
        /// Gets the first Goal with the sequence=1
        /// </summary>
        /// <returns>The main Goal with child three object Goals</returns>
        [HttpGet]
        public async Task<Goal> Get()
        {
            var client = _clientFactory.CreateClient();
            var response = await client.GetAsync($"{_lifeHackDataEndpoint}/goal/");
            var responseObject = await response.Content.ReadAsAsync<Goal>();
            return responseObject;
        }
    }
}